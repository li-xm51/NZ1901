import redis.clients.jedis.Jedis;

/**
 * @Author LXM
 * @Date 2020/6/12 0012
 */
public class JedisDemo {

    public static void main(String[] args) {

    }

    public void test1() {

        //获得连接对象
        Jedis jedis = new Jedis("192.168.153.132", 6379);

        //获得之前redis中存储的数据
        String name = jedis.get("name");
        System.out.println(name);

        //存储数据
        jedis.set("password", "123");
        System.out.println(jedis.get("password"));

        //关闭
        jedis.close();

    }

}
