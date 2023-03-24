package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;

import Beans.Product;
import BusinessLayer.ClientBusiness;
import BusinessLayer.CommandeBusiness;
import BusinessLayer.InfoBusiness;
import BusinessLayer.ProductBusiness;
import MetierLayer.User;
import Models.ProductModel;
import Models.UserModel;
import Utilities.JPAUtilities;

@WebServlet(name="Servlet", urlPatterns = {"/","/index"})
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;
	private ProductBusiness productBusiness;
	private InfoBusiness infoBusiness;
	private CommandeBusiness commandeBusiness;
	private ClientBusiness clientBusiness;
	
	private ProductModel productModel = new ProductModel();
    
    public MainServlet() {
        super();
        this.entityManager = JPAUtilities.getEntityManager("JPA_eclipselink_app");
        this.productBusiness = new ProductBusiness(entityManager);
        this.infoBusiness = new InfoBusiness(entityManager);
        this.commandeBusiness = new CommandeBusiness(entityManager);
        this.clientBusiness = new ClientBusiness(entityManager);
    }

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		productModel.setProducts(productBusiness.findAll());
		
		String path = request.getServletPath();
		
		switch (path) {
		case "/index": {
			request.setAttribute("productModel",productModel);
			request.getRequestDispatcher("/View/ProductViews/default.jsp").forward(request, response);
			break;
		}
		case "/delete":{
			int id = Integer.parseInt(request.getParameter("id"));
			Product product = productBusiness.findByID(id);
			request.setAttribute("product", product);
			request.getRequestDispatcher("/View/ProductViews/delete.jsp").forward(request, response);
			break;
		}
		case "/edit":{
			int id = Integer.parseInt(request.getParameter("id"));
			Product product = productBusiness.findByID(id);
			request.setAttribute("product", product);
			request.getRequestDispatcher("/View/ProductViews/edit.jsp").forward(request, response);
			break;
		}
		case "/add":{
			request.getRequestDispatcher("/View/ProductViews/add.jsp").forward(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		// PrintWriter writer = response.getWriter();
		// writer.print("product_id = "+id);
		
		switch (path) {
		case "/delete": {
			int id = Integer.parseInt(request.getParameter("user_id"));
			productBusiness.Delete(id);
			response.sendRedirect("index");
			break;
		}
		case "/edit": {
			int id = Integer.parseInt(request.getParameter("product_id"));
			Product product = new Product();
			product.setId(id);
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			product.setAmount(Double.parseDouble(request.getParameter("amount")));
			product.setType(request.getParameter("type"));
			Product updatedProduct = productBusiness.Modify(product);
			request.setAttribute("product", updatedProduct);
			request.getRequestDispatcher("/View/ProductViews/updated.jsp").forward(request, response);
			break;
		}
		case "/add": {
			Product product = new Product();
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			product.setAmount(Double.parseDouble(request.getParameter("amount")));
			product.setType(request.getParameter("type"));
			Product updatedProduct = productBusiness.Add(product);
			request.setAttribute("product", updatedProduct);
			request.getRequestDispatcher("/View/ProductViews/updated.jsp").forward(request, response);
			break;
		}
		case "/search": {
			String hint = request.getParameter("hint");
			productModel.setProducts(productBusiness.SearchByHint(hint));
			request.setAttribute("productModel", productModel);
			request.getRequestDispatcher("/View/ProductViews/default.jsp").forward(request, response);
			break;
		}
	}
	}
}
