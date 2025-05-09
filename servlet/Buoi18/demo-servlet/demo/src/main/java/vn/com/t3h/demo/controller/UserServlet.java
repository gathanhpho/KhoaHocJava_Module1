package vn.com.t3h.demo.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.t3h.demo.model.UserModel;
import vn.com.t3h.demo.service.IUserService;
import vn.com.t3h.demo.service.Impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;

// localhost:8080/user-manager
@WebServlet("/user-manager")
public class UserServlet extends HttpServlet {

    private IUserService iUserService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        iUserService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy ra model từ các tầng service, dao
        List<UserModel> userModelsDatabase = iUserService.getListUser();
        // gắn model vào view
        req.setAttribute("userModels", userModelsDatabase);
        // trả ra view đã chứa model
        req.getRequestDispatcher("/pages/user-manager.jsp").forward(req, resp);
    }
}