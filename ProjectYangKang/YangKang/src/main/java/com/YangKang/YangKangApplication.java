package com.YangKang;

import com.YangKang.entity.Account;
import com.YangKang.repository.IAccountRepository;
import com.YangKang.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YangKangApplication {


	public static void main(String[] args) {
		SpringApplication.run(YangKangApplication.class, args);
	}


}
