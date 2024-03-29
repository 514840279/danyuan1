package org.danyuan.download.service;

import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;

/**    
*  文件名 ： EntityP.java  
*  包    名 ： org.danyuan.download.service  
*  描    述 ： TODO(用一句话描述该文件做什么)  
*  作    者 ： Tenghui.Wang  
*  时    间 ： 2016年3月21日 下午8:50:45  
*  版    本 ： V1.0    
*/
public class EntityP {
	/**  
	*  构造方法： 
	*  描    述： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param body
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	public EntityP() {
		// TODO Auto-generated constructor stub
	}
	
	/**  
	*  构造方法： 
	*  描    述： TODO(这里用一句话描述这个方法的作用)  
	*  参    数： @param body
	*  作    者 ： Tenghui.Wang  
	*  @throws  
	*/
	public EntityP(String body) {
		if (body != null && !"".equals(body)) {
		
		}
	}
	
	public static void main(String[] args) {
		String[] testCase = new String[] { "一桶冰水当头倒下，微软的比尔盖茨、Facebook的扎克伯格跟桑德博格、亚马逊的贝索斯、苹果的库克全都不惜湿身入镜，这些硅谷的科技人，飞蛾扑火似地牺牲演出，其实全为了慈善。", "世界上最长的姓名是简森·乔伊·亚历山大·比基·卡利斯勒·达夫·埃利奥特·福克斯·伊维鲁莫·马尔尼·梅尔斯·帕特森·汤普森·华莱士·普雷斯顿。",
		};
		Segment segment = HanLP.newSegment().enableTranslatedNameRecognize(true);
		for (String sentence : testCase) {
			List<Term> termList = segment.seg(sentence);
			System.out.println(termList);
		}
	}
	
}
