import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author LXM
 * @Date 2020/6/12 0012
 */
public class JedisDemoTest {

    @Test
    public void test1() {

        //获得连接对象
        Jedis jedis = new Jedis("192.168.253.129", 6379);

        //获得之前redis中存储的数据
        jedis.set("name","jack");
        String name = jedis.get("name");
        System.out.println(name);

        //存储数据
        jedis.set("password", "123");
        System.out.println(jedis.get("password"));

        //关闭
        jedis.close();

    }

    @Test
    public void test2() {
        JedisPoolConfig poolConfig=new JedisPoolConfig();
        poolConfig.setMaxIdle(50);
        poolConfig.setMinIdle(10);// 最小闲置个数
        poolConfig.setMaxTotal(50);// 最大连接数
        JedisPool pool=new JedisPool(poolConfig,"192.168.253.129",6379);
        Jedis jedis=pool.getResource();
        jedis.set("age","123");
        System.out.println(jedis.get("age"));
        jedis.close();
        pool.close();
//        // 创建池子的配置对象
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
//        poolConfig.setMaxIdle(30);// 最大闲置个数
//        poolConfig.setMinIdle(10);// 最小闲置个数
//        poolConfig.setMaxTotal(50);// 最大连接数
//        // 1、创建一个redis的连接池
//        JedisPool pool = new JedisPool(poolConfig, "192.168.253.129", 6379);
//        // 2、从池子中获取redis的连接资源
//        Jedis jedis = pool.getResource();
//        // 3、操作数据库
//        jedis.set("age", "18");
//        System.out.println(jedis.get("age"));
//        // 4、关闭资源
//        jedis.close();
//        pool.close();
    }
}
