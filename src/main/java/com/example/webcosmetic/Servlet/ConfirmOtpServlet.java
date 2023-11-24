package com.example.webcosmetic.Servlet;

import com.example.webcosmetic.Util.MailUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "otp", value = "/otp")
public class ConfirmOtpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String from = "bananacosmeticweb@gmail.com";
        String subject = "Banana Cosmetic";
        String to = req.getParameter("email");
        String name = req.getParameter("name");
        String otp = generateOtp();
        HttpSession session = req.getSession();
        session.setAttribute("otpRegister",otp);
        session.setMaxInactiveInterval(300);
        String body = "<!DOCTYPE html>"
                + "<html lang=\"vi\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "    <title>Xác nhận OTP</title>"
                + " <style>\n" +
                "        \n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            font-size: 14px;\n" +
                "            color: #333333;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "    \n" +
                "        .container {\n" +
                "            max-width: 600px;\n" +
                "            margin: 0 auto;\n" +
                "            border: 5px solid pink; \n" +
                "            border-radius: 10px; \n" +
                "        }\n" +
                "    \n" +
                "        .header {\n" +
                "            background-image: url('https://res.cloudinary.com/drncbsuo5/image/upload/v1700805848/mhfsicbdk8ctybygcs0h.jpg');\n" +
                "            padding: 20px;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "    \n" +
                "        .content {\n" +
                "            padding: 20px;\n" +
                "        }\n" +
                "    \n" +
                "       \n" +
                "        h1 {\n" +
                "            color: pink;\n" +
                "        }\n" +
                "    \n" +
                "        p {\n" +
                "            line-height: 1.5;\n" +
                "        }\n" +
                "    \n" +
                "        a {\n" +
                "            color: #0099ff;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "    </style>"
                + "</head>"
                + "<body style=\"font-family: Arial, sans-serif; padding: 20px;\">"
                + "  <div class=\"container\">\n" +
                "        <div class=\"header\">\n" +
                "            <!-- Thêm ảnh của web của bạn vào đây -->\n" +
                "            <img src=\"https://res.cloudinary.com/drncbsuo5/image/upload/v1700805347/axghphnd5zngzniggcvx.jpg\" alt=\"Logo của web của bạn\" width=\"200\" height=\"200\">\n" +
                "        </div>\n" +
                "        <div class=\"content\">\n" +
                "            <h1>Banana Cosmetic</h1>\n" +
                "            <p>Xin chào, " + name + " !</p>\n" +
                "            <p>Cảm ơn bạn đã đăng ký tại Banana Cosmetic. Đây là mã OTP của bạn để hoàn thành quá trình đăng ký:</p>\n" +
                "            <p><strong style=\"color: rgb(226, 119, 137);\">" + otp + "</strong></p>\n" +
                "            <p>Vui lòng nhập mã OTP này vào trang web của chúng tôi để xác nhận đăng ký của bạn.</p>\n" +
                "            <p>Cảm ơn bạn đã sử dụng web của chúng tôi!</p>\n" +
                "            <p>Trân trọng,</p>\n" +
                "            <p>Banana Cosmetic Team</p>\n" +
                "        </div>\n" +
                "    </div>"
                + "</body>"
                + "</html>";

        try {
            MailUtil.sendMail(to, from, subject, body, true);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateOtp() {
        Random random = new Random();
        int otp = random.nextInt(900000) + 100000;
        return String.valueOf(otp);
    }

}
