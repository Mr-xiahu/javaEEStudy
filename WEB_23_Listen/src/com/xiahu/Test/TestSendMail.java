package com.xiahu.Test;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.xiahu.utils.MailUtils;

public class TestSendMail {
	public static void main(String[] args) throws AddressException, MessagingException {
		MailUtils.sendMail("Tom@qq.com", "打招呼", "你好，我只是单纯的想跟你打招呼");
	}

}
