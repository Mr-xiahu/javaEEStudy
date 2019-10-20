package com.xiahu.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {

	@Test
	public void test() {

		// 连接Redis数据库
		Jedis jedis = new Jedis("192.168.25.1", 6379);

		// 取数据
		String username = jedis.get("username");
		System.out.println(username);

		// 存数据
		String set = jedis.set("address", "湖北省孝感市孝南区");
		System.out.println(set);

	}

	// 使用jedispool连接池连接
	@Test
	public void test2() {
		// new一个jedispool的配置文件
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		// 设置属性
		poolConfig.setMaxIdle(30);// 最大闲置数
		poolConfig.setMinIdle(10);// 最小闲置数
		poolConfig.setMaxTotal(100);// 最大连接数

		// 连接redis数据库
		JedisPool pool = new JedisPool(poolConfig, "192.168.25.1", 6379);
		System.out.println("连接成功");

		// 获得连接对象
		Jedis jedis = pool.getResource();

		// 数据库操作
		jedis.set("xxx", "yyyy");
		System.out.println(jedis.get("xxx"));

		// 关闭资源
		jedis.close();
		pool.close();

	}

}
