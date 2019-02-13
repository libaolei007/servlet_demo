package com.servlet.demo.session;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @description:生成验证码
 * @author: libl
 * @date: 2019年2月13日 上午10:26:14
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 120;
	public static final int HEIGHT = 50;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();

		// 1. 设置背景色
		this.setBackground(g);

		// 2. 设置边框
		this.setBorder(g);

		// 3. 画干扰线
		this.drawRandomLine(g);

		// 4. 写随机数
		String random = this.drawRandomNum((Graphics2D) g);
		request.getSession().setAttribute("checkcode", random);

		// 5. 图片写给浏览器
		response.setContentType("image/jpeg");
		// 控制浏览器不要缓存图片
		response.setDateHeader("expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");

		ImageIO.write(image, "jpg", response.getOutputStream());

	}

	private void setBackground(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}

	private void setBorder(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
	}

	private void drawRandomLine(Graphics g) {
		g.setColor(Color.GREEN);
		for (int i = 0; i < 5; i++) {
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);

			int x2 = new Random().nextInt(WIDTH);
			int y2 = new Random().nextInt(HEIGHT);
			g.drawLine(x1, y1, x2, y2);
		}
	}

	private String drawRandomNum(Graphics2D g) {
		int fontSize = 20;
		g.setColor(Color.RED);
		g.setFont(new Font("宋体", Font.BOLD, fontSize));

		String base = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";
		int fontNum = 4;
		int y = 32;
		int x = 18;
		String ch;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < fontNum; i++) {
			int degree = new Random().nextInt() % 30;
			double radian = degree * Math.PI / 180; // 弧度
			g.rotate(radian, x, y); // 设置旋转的弧度

			ch = base.charAt(new Random().nextInt(base.length())) + "";
			sb.append(ch);
			g.drawString(ch, x, y);

			g.rotate(-radian, x, y);
			x += 25;
		}
		return sb.toString();
	}
}
