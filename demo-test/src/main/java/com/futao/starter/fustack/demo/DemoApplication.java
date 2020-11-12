package com.futao.starter.fustack.demo;

import com.futao.starter.fustack.redis.serialnum.IKeyDefinition;
import com.futao.starter.fustack.redis.serialnum.IRejectPolicy;
import com.futao.starter.fustack.redis.serialnum.RejectPolicy;
import com.futao.starter.fustack.redis.serialnum.SerialNumberGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author futao
 * @date 2020/10/30
 */
@Slf4j
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Autowired
    private SerialNumberGenerator serialNumberGenerator;

    @Override
    public void run(String... args) throws Exception {

        TimeUnit.SECONDS.sleep(5);

        log.info("{}", "go");

        CountDownLatch countDownLatch = new CountDownLatch(1);

        int i1 = 12;

        ExecutorService executorService = Executors.newFixedThreadPool(i1);
        for (int i = 0; i < i1; i++) {
            executorService.execute(() -> {
                try {
                    log.info("稍等");
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 200000; j++) {
                    String next = serialNumberGenerator.next(new IKeyDefinition() {
                        @Override
                        public boolean dateTimePrefix() {
                            return true;
                        }

                        @Override
                        public String dateTimePrefixPattern() {
                            return "yyyyMMdd";
                        }

                        @Override
                        public int length() {
                            return 6;
                        }

                        @Override
                        public String redisKey() {
                            return "orderNum";
                        }

                        @Override
                        public IRejectPolicy rejectPolicy() {
                            return new RejectPolicy.ThrowExceptionPolicy();
                        }
                    });
                    log.info("{}", next);
                }
            });
        }
        TimeUnit.SECONDS.sleep(1L);
        countDownLatch.countDown();
    }
}
