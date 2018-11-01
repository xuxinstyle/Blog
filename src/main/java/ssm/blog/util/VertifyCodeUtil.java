package ssm.blog.util;

import java.awt.*;
/*import java.awt.Font;
import java.awt.Graphics;*/
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author xp
 * @Description 验证码生成工具类
 * @Date 2017/4/21 20:12
 */
public class VertifyCodeUtil extends HttpServlet{
	/*public VertifyCodeUtil(){
		super();
	}
	public void destroy(){
		super.destroy();
	}
	public void init() throws ServletException{
		super.init();
	}*/
    // 使用到Algerian字体，系统里没有的话需要安装字体，字体只显示大写，去掉了1,0,i,o几个容易混淆的字符
    public static final String VERTIFY_CODE = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
   /* Color getRandColor(int fc,int bc){
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
    @Override
    public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	response.setHeader("Pragma", "No-cache");
    	response.setHeader("Cache-Control", "no-cache");
    	response.setDateHeader("Expires", 0);
    	int width = 60, height = 20;
    	BufferedImage image = new BufferedImage(width, height,
    			BufferedImage.TYPE_INT_RGB);
    	Graphics g = image.getGraphics();
    	Random random = new Random();
    	g.setColor(getRandColor(200, 250));
    	g.fillRect(0, 0, width, height);
    	g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
    	g.setColor(getRandColor(160, 200));
    	for (int i = 0; i < 155; i++) {
    		int x = random.nextInt(width);
    		int y = random.nextInt(height);
    		int xl = random.nextInt(12);
    		int yl = random.nextInt(12);
    		g.drawLine(x, y, x + xl, y + yl);
    	}
    	String sRand = "";
    	for (int i = 0; i < 4; i++) {
    		String rand = String.valueOf(random.nextInt(10));
    		sRand += rand;
    		g.setColor(new Color(20 + random.nextInt(110), 20 + random
    				.nextInt(110), 20 + random.nextInt(110)));
    		g.drawString(rand, 13 * i + 6, 16);
    	}
    	HttpSession session=request.getSession(true);
    	// 将验证码存入SESSION
    	session.setAttribute("sRand", sRand);
    	g.dispose();
    	ImageIO.write(image, "JPEG", response.getOutputStream());
    	
    }
  */
	




}
