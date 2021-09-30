package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import Model.SinhVien;
import services.Readfilediemdanh;

import javax.servlet.annotation.MultipartConfig;

@MultipartConfig()
@WebServlet("/Readlsistmark")
public class Readlsistmark extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Readfilediemdanh diemdanh;
	private ArrayList<SinhVien> lstsvthi;
	private ArrayList<SinhVien> lstsvcamthi;

	public Readlsistmark() {
		this.diemdanh = new Readfilediemdanh();
		this.lstsvcamthi = new ArrayList<SinhVien>();
		this.lstsvthi = new ArrayList<SinhVien>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/views/formUpLoadDiem.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String loaimon = request.getParameter("Category");
		String namefile = request.getParameter("namefile");
		System.out.println(loaimon + "abc");
		System.out.println(namefile + "abc");
		if (namefile != null) {

		} else {
			String file=readurlfile(request, response);
				this.diemdanh.kiemTra(file);
				this.lstsvcamthi = this.diemdanh.xuatsvcamthi();
				this.lstsvthi = this.diemdanh.xuatsvthi();
				for (SinhVien x : lstsvcamthi) {
					System.out.println(x.getIdSV() + "\t" + "," + "\t" + x.getNameSV() + "\t" + "," + "\t" + x.getMark()
							+ "\t" + "," + "\t" + x.getStatus() + "\n");
				}
				for (SinhVien x : lstsvthi) {
					System.out.println(x.getIdSV() + "\t" + "," + "\t" + x.getNameSV() + "\t" + "," + "\t" + x.getMark()
							+ "\t" + "," + "\t" + x.getStatus() + "\n");
				}
		}
		request.getRequestDispatcher("/views/formUpLoadDiem.jsp").forward(request, response);
	}

	private String readurlfile(HttpServletRequest request, HttpServletResponse response) {
		String filename = null;
		try {
			Part part = request.getPart("namefile");
			String realpath = request.getServletContext().getRealPath("/filemarks");
			String namefile = Path.of(part.getSubmittedFileName()).getFileName().toString();
			if (!Files.exists(Path.of(realpath))) {
				Files.createDirectory(Path.of(realpath));
			}
			part.write(realpath + System.getProperty("file.separator") + namefile);
			System.out.print(realpath + System.getProperty("file.separator") + namefile);
			filename = realpath + System.getProperty("file.separator") + namefile;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filename;
	}

}
