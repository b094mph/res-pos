package com.res.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.res.constant.ResConstant;

public class Price {
	
	public static BigDecimal roundToNearestNickel(BigDecimal num){
		BigDecimal result = null;
		
		int digit = num.multiply(new BigDecimal(100)).intValue()%10;
		
		switch(digit){
			case 0: case 1: case 2:
				result = new BigDecimal(Math.floor(num.doubleValue()*20)/20);
				break;
			case 3: case 4:
				result = new BigDecimal(Math.ceil(num.doubleValue()*20)/20);
				break;
			case 6: case 7:
				result = new BigDecimal(Math.floor(num.doubleValue()*20)/20);
				break;
			default: // 5,8,9
				result = new BigDecimal(Math.ceil(num.doubleValue()*20)/20);
				break;
		}
		return result.setScale(ResConstant.SCALE, RoundingMode.HALF_UP);
	}
}
