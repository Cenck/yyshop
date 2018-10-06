package com.cengel.yyshop.mqe;

import com.cengel.mq.mqe.AbstractMqe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/28 - 17:25
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGoodsOrderMqe extends AbstractMqe implements Serializable {
	private Integer    seckId;
	private BigDecimal buyAmount;
	private BigDecimal discountPrice;
	private Integer    memberId;
	private Integer    seckOrderId;
}
