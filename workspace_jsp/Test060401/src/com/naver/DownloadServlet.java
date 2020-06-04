package com.naver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//업로드 폴더 주소
		String fileName = request.getParameter("fileName");
		String uploadPath= "C:"+File.separator+"upload";
//		String uploadPath = request.getServletContext().getRealPath("img");
		//파일 경로
		String filePath = uploadPath+File.separator+fileName;
		File f= new File(filePath);
		InputStream in= null;
		try {
			
			in= new FileInputStream(f);//우리가 (만든)관리하는 자원 /반드시 닫아줘야함
			//요기까지가 업로드 파일 준비
			
			//여기서 부터 다운로드 환경설정 헤더값설정부분
			//시스템에서 제공해주는 outputStream
			String sMimeType= getServletContext().getMimeType(filePath);//filepath의 mimetype확인
			if(sMimeType ==null) {
				sMimeType= "application/octet-stream";//(마인타입을 모를떄)어떤타입인지 모를때 ~그냥 다운받으세요 하는 뜻
			}
			response.setContentType(sMimeType);
			
			//여기서 인코딩 해서 보내도 브라우저에서 깨질수 있기때문에 브라우저(8859_1)에 맞춰서 인코딩 방식 수정
			String encoding= new String (fileName.getBytes("utf-8"),"8859_1");
			
			response.setHeader("Content-Disposition",
								"attachment;filename="+encoding);			
			
			//여기까지가 다운로드위한 환경설정
			ServletOutputStream out =response.getOutputStream();//컨테이너가 관리하는 자원우리가 가져다 사용/우리가 만든거 아님
			byte[] arr= new byte[1024];
			int leng=-1;//몇개를 넣엇는지 배열 에 넣을 수 있는 변수가  필요
			while(true) {
				leng=in.read(arr, 0, arr.length);
				//arr의 배열에 0번째 부터 arr.lengh(받아온만큼)
						if(leng==-1) {//더이상 읽어올것이 없습니다
							break;
							
						}
				out.write(arr, 0, leng);//arr에서 받아오는데 0 부터leng개 까지 받아옴
			}
			out.flush();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally {
			try {
				if(in!=null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();// TODO: handle exception
			}
		}
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
