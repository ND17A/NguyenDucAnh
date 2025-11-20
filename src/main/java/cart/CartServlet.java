package cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response); // GET cũng xử lý như POST
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        
        // Lấy giỏ hàng từ session, nếu chưa có thì tạo mới
        @SuppressWarnings("unchecked")
        List<LineItem> cart = (List<LineItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");

        if (action == null || action.isEmpty()) {
            action = "view"; // mặc định là xem giỏ hàng
        }

        String url = "/cart.jsp";

        switch (action) {
            case "add":
                addToCart(request, cart);
                url = "/cart.jsp"; // SỬA Ở ĐÂY: Chuyển sang cart.jsp sau khi thêm
                break;

            case "update":
                updateCart(request, cart);
                break;

            case "remove":
                removeFromCart(request, cart);
                break;

            case "continue":
                url = "/index.jsp";
                break;

            case "checkout":
                url = "/checkout.jsp"; // bạn có thể tạo sau
                break;

            case "view":
            default:
                // chỉ hiển thị giỏ hàng
                break;
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    private void addToCart(HttpServletRequest request, List<LineItem> cart) {
        String code = request.getParameter("productCode");
        Product product = ProductDB.getProduct(code);

        LineItem item = null;
        for (LineItem li : cart) {
            if (li.getProduct().getCode().equals(code)) {
                item = li;
                break;
            }
        }

        if (item == null) {
            item = new LineItem();
            item.setProduct(product);
            item.setQuantity(1);
            cart.add(item);
        } else {
            item.setQuantity(item.getQuantity() + 1);
        }
    }

    private void updateCart(HttpServletRequest request, List<LineItem> cart) {
        String[] codes = request.getParameterValues("code");
        String[] quantities = request.getParameterValues("quantity");

        if (codes != null && quantities != null) {
            for (int i = 0; i < codes.length; i++) {
                String code = codes[i];
                int qty;
                try {
                    qty = Integer.parseInt(quantities[i]);
                } catch (NumberFormatException e) {
                    qty = 1;
                }

                if (qty <= 0) {
                    // xóa nếu số lượng <= 0
                    cart.removeIf(item -> item.getProduct().getCode().equals(code));
                } else {
                    for (LineItem item : cart) {
                        if (item.getProduct().getCode().equals(code)) {
                            item.setQuantity(qty);
                            break;
                        }
                    }
                }
            }
        }
    }

    private void removeFromCart(HttpServletRequest request, List<LineItem> cart) {
        String code = request.getParameter("removeCode");
        if (code != null) {
            cart.removeIf(item -> item.getProduct().getCode().equals(code));
        }
    }
}