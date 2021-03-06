/**
 * 描述: 
 * OptionalTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.jdk;

//静态导入
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.hua.entity.User;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * OptionalTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class OptionalTest extends BaseTest {

	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testOptional() {
		try {
			User user = new User();
			user.setNickname("haha");
			Optional<User> optional = Optional.of(user);
			
			System.out.println(optional.get().toString());
			
			// java.lang.NullPointerException
			optional = Optional.of(null);
			System.out.println(optional.get().toString());
			
		} catch (Exception e) {
			log.error("testOptional =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testEmpty() {
		try {
			Optional<User> optional = Optional.empty();
			
			//判断是否存在
			System.out.println(optional.isPresent());
			/*
			 * java.util.NoSuchElementException: No value present
			 */
			System.out.println(optional.get().toString());
		} catch (Exception e) {
			log.error("testEmpty =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testOrElse() {
		try {
			Optional<User> optional = Optional.empty();
			/*
			 * 为空则取指定值
			 * 符合条件则返回指定的值，对原来Optional对象没有影响
			 */
			User newUser = optional.orElse(new User());
			//判断是否存在
			System.out.println(optional.isPresent());
			/*
			 * java.util.NoSuchElementException: No value present
			 */
			System.out.println(optional.get().toString());
			
			System.out.println(newUser.toString());
			
		} catch (Exception e) {
			log.error("testOrElse =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testOfNullable() {
		try {
			Optional<User> optional = Optional.ofNullable(null);
			/*
			 * 为空则取指定值
			 * 符合条件则返回指定的值，对原来Optional对象没有影响
			 */
			User newUser = optional.orElse(new User());
			//判断是否存在
			System.out.println(optional.isPresent());
			/*
			 * java.util.NoSuchElementException: No value present
			 */
			System.out.println(optional.get().toString());
			
			System.out.println(newUser.toString());
			
		} catch (Exception e) {
			log.error("testOfNullable =====> ", e);
		}
	}
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testOrElseGet() {
		try {
			Optional<User> optional = Optional.ofNullable(null);
			//User user = optional.orElseGet(() -> new User());
			User user = optional.orElseGet(User::new);
			System.out.println(user.toString());
			
		} catch (Exception e) {
			log.error("testOrElseGet =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMap() {
		try {
			User user = new User();
			user.setNickname("haha");
			Optional<User> optional = Optional.of(user); 
			//Optional<String> nameOptional = optional.map((x) -> x.getNickname());
			Optional<String> nameOptional = optional.map(User :: getNickname);
			log.info("testMap =====> " + nameOptional.get());
			
		} catch (Exception e) {
			log.error("testMap =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFlatMap() {
		try {
			User user = new User();
			user.setNickname("haha");
			Optional<User> optional = Optional.of(user); 
			// flagMap 需要再返回 Optional
			Optional<String> nameOptional = optional.flatMap((x) -> Optional.of(x.getNickname()));
			log.info("testFlatMap =====> " + nameOptional.get());
			
		} catch (Exception e) {
			log.error("testFlatMap =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testTemp")
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testCommon")
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testSimple")
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testBase")
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("beforeMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@BeforeEach
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("afterMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@AfterEach
	public void afterMethod() {
		System.out.println("afterMethod()");
	}
	
	/**
	 * 
	 * 描述: 测试忽略的方法
	 * @author qye.zheng
	 * 
	 */
	@Disabled
	@DisplayName("ignoreMethod")
	@Test
	public void ignoreMethod() {
		System.out.println("ignoreMethod()");
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("noUse")
	@Disabled("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(expecteds, actuals, message);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(true, message);
		assertTrue(true, message);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(expecteds, actuals, message);
		assertNotSame(expecteds, actuals, message);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(actuals, message);
		assertNotNull(actuals, message);
		
		fail();
		fail("Not yet implemented");
		
		dynamicTest(null, null);
		
		assumeFalse(false);
		assumeTrue(true);
		assumingThat(true, null);
	}

}
