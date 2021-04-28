package com.example.testproject.config.cache;


import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * redis本身没有并行/并发的概念，
 * 必须保证调用redis时一定是串行否则会引起调用混乱。
 *
 * @author Hasee
 */
@Service
public class JedisService {
    private Jedis jedis = new Jedis("127.0.0.1", 6379);
    private final Lock lock = new ReentrantLock();
    private final String wangzhi = "https://blog.csdn.net/qq_33551891/article/details/89259869";


    /**
     * 创建set
     *
     * @param key
     * @return
     */
    public void set(String key, String value) {
        lock.lock();
        try {
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 添加去重元素
     *
     * @param key
     * @return
     */
    /*public Long sadd(String key, String... value) {
        long successCount = 0;
        lock.lock();
        try {
            successCount = jedis.sadd(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return successCount;
    }

    *//**
     * 弹出随机一条数据
     *
     * @param key
     * @return
     *//*
    public String spop(String key) {
        String members = null;
        lock.lock();
        try {
            members = jedis.spop(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return members;
    }


    *//**
     * 查询数量
     *
     * @param key
     * @return
     *//*
    public Long scard(String key) {
        long successCount = 0;
        lock.lock();
        try {
            successCount = jedis.scard(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return successCount;
    }

    public WenshuParam getWenShuParamByJson(String json) {
        if (StringUtil.isEmpty(json)) {
            return null;
        }
        Gson gson = new Gson();
        Map map = gson.fromJson(json, Map.class);
        WenshuParam wenshuParam = new WenshuParam();
        wenshuParam.setId(new ObjectId(map.get("id").toString()));
        wenshuParam.setParam(getStringParam(map, "param"));
        wenshuParam.setHasCrawl("true".equals(getStringParam(map, "hasCrawl")));
        wenshuParam.setFinalParam("true".equals(getStringParam(map, "finalParam")));
        wenshuParam.setCount(Integer.parseInt(getStringParam(map, "count")));
        wenshuParam.setParentId(getStringParam(map, "parentId"));
        wenshuParam.setConditionType(getStringParam(map, "ConditionType"));
        wenshuParam.setParval(getStringParam(map, "parval"));
        wenshuParam.setHasCrawledPageNum(Integer.parseInt(getStringParam(map, "hasCrawledPageNum")));
        wenshuParam.setDirection(getStringParam(map, "direction"));
        return wenshuParam;
    }

    private String getStringParam(Map map, String key) {
        return Optional.ofNullable(map.get(key)).orElse("").toString();
    }
*/
}