package com.alibaba.simpleEL.bvt.dialect.tiny;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.alibaba.simpleEL.dialect.tiny.TinyELEvalService;

public class Statement_case4 extends TestCase {
	public void test_0() throws Exception {
		TinyELEvalService service = new TinyELEvalService();
		service.setAllowMultiStatement(true);
		service.regsiterVariant(int.class, "a", "b");

		Map<String, Object> ctx = new HashMap<String, Object>();
		ctx.put("a", 3);
		ctx.put("b", 4);

		Assert.assertEquals(48, service.eval(ctx, "int i = 0; while (i < 10) { a += i++; } return a;"));
		
		Assert.assertEquals(48, ctx.get("a"));
		Assert.assertEquals(4, ctx.get("b"));
	}

	   public void test_1() throws Exception {
	        TinyELEvalService service = new TinyELEvalService();
	        service.setAllowMultiStatement(true);
	        service.regsiterVariant(int.class, "a", "b");

	        Map<String, Object> ctx = new HashMap<String, Object>();
	        ctx.put("a", 3);
	        ctx.put("b", 4);

	        Assert.assertEquals(48, service.eval(ctx, "int i = 0; while (i < 10) { @a += i++; } return @a;"));
	        
	        Assert.assertEquals(48, ctx.get("a"));
	        Assert.assertEquals(4, ctx.get("b"));
	    }
}
