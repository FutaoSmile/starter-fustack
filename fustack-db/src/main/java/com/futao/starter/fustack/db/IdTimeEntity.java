package com.futao.starter.fustack.db;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.futao.starter.fustack.consts.Constants;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 数据库实体基类
 *
 * @author futao
 * @date 2020/11/2
 */
@Getter
@Setter
public class IdTimeEntity {

    /**
     * 主键自增
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = Constants.Time.DATE_TIME_COMPLETE, timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDateTime;

    /**
     * 修改人
     */
    @TableField(fill = FieldFill.UPDATE)
    private Long updatedBy;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = Constants.Time.DATE_TIME_COMPLETE, timezone = "GMT+8")
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateDateTime;

}
