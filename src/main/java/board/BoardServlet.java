package board;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardDAO
 */
@WebServlet("/board1004")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardDAO dao = new BoardDAO();
		String tdText = request.getParameter("tdText");
		String command = request.getParameter("command");
		if(command!=null && command.equals("addBoard")) {
			String dateS = request.getParameter("tdDate");
			System.out.println(dateS);
			try{
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date tdDate = formatter.parse(dateS);
				BoardVO boardVO = new BoardVO();
				boardVO.setTdText(tdText);
				boardVO.setTdDate(tdDate);
				dao.addBoard(boardVO);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command!=null && command.equals("delete")) {
			int bno = Integer.parseInt(request.getParameter("bno"));
			dao.delBoard(bno);
		}
		
		List<BoardVO> listBoard = dao.listBoard();
		request.setAttribute("listBoard", listBoard);
		RequestDispatcher dispatch = request.getRequestDispatcher("board.jsp");
		dispatch.forward(request, response);
		
	}

}
