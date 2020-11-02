package com.futao.starter.fustack.db.entity.autoconfiguration;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.futao.starter.fusstack.foundation.user.CurrentUserId;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author futao
 * @date 2020/11/2
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.debug("exe");
        this.strictInsertFill(metaObject, "createBy", CurrentUserId::get, Long.class);
        this.strictInsertFill(metaObject, "createDateTime", () -> LocalDateTime.now(ZoneOffset.ofHours(8)), LocalDateTime.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("exe");
        this.strictUpdateFill(metaObject, "updatedBy", CurrentUserId::get, Long.class);
        this.strictUpdateFill(metaObject, "updatedDateTime", () -> LocalDateTime.now(ZoneOffset.ofHours(8)), LocalDateTime.class);
    }
}
