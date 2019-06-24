package com.wh.utils;


import com.wh.exception.LsException;
import com.wh.toos.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
//
//    private static double size = Math.pow(2, 32);
//    /**
//     * 写入缓存
//     *
//     * @param key
//     * @param offset   位 8Bit=1Byte
//     * @return
//     */
//    public boolean setBit(String key, long offset, boolean isShow) {
//        boolean result = false;
//        try {
//            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
//            operations.setBit(key, offset, isShow);
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    /**
//     * 写入缓存
//     *
//     * @param key
//     * @param offset
//     * @return
//     */
//    public boolean getBit(String key, long offset) {
//        boolean result = false;
//        try {
//            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
//            result = operations.getBit(key, offset);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//
//    /**
//     * 写入缓存
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public boolean set(final String key, Object value) {
//        boolean result = false;
//        try {
//            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
//            operations.set(key, value);
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    /**
//     * 写入缓存设置时效时间
//     *
//     * @param key
//     * @param value
//     * @return
//     */
//    public boolean set(final String key, Object value, Long expireTime) {
//        boolean result = false;
//        try {
//            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
//            operations.set(key, value);
//            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    /**
//     * 批量删除对应的value
//     *
//     * @param keys
//     */
//    public void remove(final String... keys) {
//        for (String key : keys) {
//            remove(key);
//        }
//    }
//
//
//    /**
//     * 删除对应的value
//     *
//     * @param key
//     */
//    public void remove(final String key) {
//        if (exists(key)) {
//            redisTemplate.delete(key);
//        }
//    }
//
//    /**
//     * 判断缓存中是否有对应的value
//     *
//     * @param key
//     * @return
//     */
//    public boolean exists(final String key) {
//        return redisTemplate.hasKey(key);
//    }
//
//    /**
//     * 读取缓存
//     *
//     * @param key
//     * @return
//     */
//    public Object get(final String key) {
//        Object result = null;
//        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
//        result = operations.get(key);
//        return result;
//    }
//
//    /**
//     * 哈希 添加
//     *
//     * @param key
//     * @param hashKey
//     * @param value
//     */
//    public void hmSet(String key, Object hashKey, Object value) {
//        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
//        hash.put(key, hashKey, value);
//    }
//
//    /**
//     * 哈希获取数据
//     *
//     * @param key
//     * @param hashKey
//     * @return
//     */
//    public Object hmGet(String key, Object hashKey) {
//        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
//        return hash.get(key, hashKey);
//    }
//
//    /**
//     * 列表添加
//     *
//     * @param k
//     * @param v
//     */
//    public void lPush(String k, Object v) {
//        ListOperations<String, Object> list = redisTemplate.opsForList();
//        list.rightPush(k, v);
//    }
//
//    /**
//     * 列表获取
//     *
//     * @param k
//     * @param l
//     * @param l1
//     * @return
//     */
//    public List<Object> lRange(String k, long l, long l1) {
//        ListOperations<String, Object> list = redisTemplate.opsForList();
//        return list.range(k, l, l1);
//    }
//
//    /**
//     * 集合添加
//     *
//     * @param key
//     * @param value
//     */
//    public void add(String key, Object value) {
//        SetOperations<String, Object> set = redisTemplate.opsForSet();
//        set.add(key, value);
//    }
//
//    /**
//     * 集合获取
//     *
//     * @param key
//     * @return
//     */
//    public Set<Object> setMembers(String key) {
//        SetOperations<String, Object> set = redisTemplate.opsForSet();
//        return set.members(key);
//    }
//
//    /**
//     * 有序集合添加
//     *
//     * @param key
//     * @param value
//     * @param scoure
//     */
//    public void zAdd(String key, Object value, double scoure) {
//        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
//        zset.add(key, value, scoure);
//    }
//
//    /**
//     * 有序集合获取
//     *
//     * @param key
//     * @param scoure
//     * @param scoure1
//     * @return
//     */
//    public Set<Object> rangeByScore(String key, double scoure, double scoure1) {
//        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
//        redisTemplate.opsForValue();
//        return zset.rangeByScore(key, scoure, scoure1);
//    }
//
//
//    //第一次加载的时候将数据加载到redis中
//    public void saveDataToRedis(String name) {
//        double index = Math.abs(name.hashCode() % size);
//        long indexLong = new Double(index).longValue();
//        boolean availableUsers = setBit("availableUsers", indexLong, true);
//    }
//
//    //第一次加载的时候将数据加载到redis中
//    public boolean getDataToRedis(String name) {
//
//        double index = Math.abs(name.hashCode() % size);
//        long indexLong = new Double(index).longValue();
//        return getBit("availableUsers", indexLong);
//    }
//
//    /**
//     * 有序集合获取排名
//     *
//     * @param key 集合名称
//     * @param value 值
//     */
//    public Long zRank(String key, Object value) {
//        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
//        return zset.rank(key,value);
//    }
//
//
//    /**
//     * 有序集合获取排名
//     *
//     * @param key
//     */
//    public Set<ZSetOperations.TypedTuple<Object>> zRankWithScore(String key, long start, long end) {
//        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
//        Set<ZSetOperations.TypedTuple<Object>> ret = zset.rangeWithScores(key,start,end);
//        return ret;
//    }
//
//    /**
//     * 有序集合添加
//     *
//     * @param key
//     * @param value
//     */
//    public Double zSetScore(String key, Object value) {
//        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
//        return zset.score(key,value);
//    }
//
//
//    /**
//     * 有序集合添加分数
//     *
//     * @param key
//     * @param value
//     * @param scoure
//     */
//    public void incrementScore(String key, Object value, double scoure) {
//        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
//        zset.incrementScore(key, value, scoure);
//    }
//
//
//    /**
//     * 有序集合获取排名
//     *
//     * @param key
//     */
//    public Set<ZSetOperations.TypedTuple<Object>> reverseZRankWithScore(String key, long start,long end) {
//        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
//        Set<ZSetOperations.TypedTuple<Object>> ret = zset.reverseRangeByScoreWithScores(key,start,end);
//        return ret;
//    }
//
//    /**
//     * 有序集合获取排名
//     *
//     * @param key
//     */
//    public Set<ZSetOperations.TypedTuple<Object>> reverseZRankWithRank(String key, long start, long end) {
//        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
//        Set<ZSetOperations.TypedTuple<Object>> ret = zset.reverseRangeWithScores(key, start, end);
//        return ret;
//    }


    // stringRedisTemplate.opsForValue();//操作字符串
    // stringRedisTemplate.opsForHash();//操作hash
    // stringRedisTemplate.opsForList();//操作list
    // stringRedisTemplate.opsForSet();//操作set
    // stringRedisTemplate.opsForZSet();//操作有序set


    /**
     * 生成user key
     *
     * @param key
     * @return
     */
    public static String redisTokenKey(String key, String tenant) {
        return Constants.SSO_TOKEN + ":" + key + "_" + tenant;
    }

    /**
     * 分布式 加锁
     *
     * @return
     */
    public String lockRedis(String lockKey, Long acquireTimeout, Long timeOut) {
        String retIdentifierValue;
        // 随机生成一个value
        String identifierValue = UuIDUtils.uuId();
        // 定义锁的名称
        String lockName = "redis_lock" + lockKey;
        //获得锁的超时时间
        int expireLock = (int) (timeOut / 1000);
        // 定义在没有获取锁之前,锁的超时时间
        long endTime = System.currentTimeMillis() + acquireTimeout;
        while (System.currentTimeMillis() < endTime) {
            // 6.使用setNx方法设置锁值
            if (setNx(lockName, identifierValue)) {
                System.out.println("上锁成功......");
                // 7.判断返回结果如果为1,则可以成功获取锁,并且设置锁的超时时间
                stringRedisTemplate.expire(lockName, expireLock, TimeUnit.SECONDS);
                retIdentifierValue = identifierValue;
                return retIdentifierValue;
            }
            // 8.否则情况下继续循环等待
        }
        return null;
    }

    /**
     * 释放锁
     *
     * @return
     */
    public boolean releaseLock(String lockKey, String identifier) {
        // 2.定义锁的名称
        String lockName = "redis_lock" + lockKey;
        // 3.如果value与redis中一直直接删除，否则等待超时
        if (identifier.equals(getStringKey(lockName))) {
            if (delKey(lockName)) {
                System.out.println(identifier + "-------解锁成功......");
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁
     *
     * @param target
     * @param timeStamp
     */
    public void unlock(String target, String timeStamp) {
        try {
            String currentValue = stringRedisTemplate.opsForValue().get(target);
            if (StringUtils.isNotBlank(currentValue) && currentValue.equals(timeStamp)) {
                // 删除锁状态
                stringRedisTemplate.opsForValue().getOperations().delete(target);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("警报！警报！警报！解锁异常{}");
        }
    }

    /**
     * 定义成功一个方法调用
     *
     * @return
     */
    public ValueOperations<String, String> ForValue() {
        return stringRedisTemplate.opsForValue();
    }

    // String方法无time
    public boolean setString(String key, Object value) {
        return setObject(key, value, null);
    }

    // String方法有time
    public boolean setString(String key, Object value, Long time) {
        return setObject(key, value, time);
    }

    // List方法
    public void setList(String key, Object value) {
        this.setObject(key, value, null);
    }

    private boolean setObject(String key, Object value, Long time) {
        try {
            // redis几张有效期限 string list set zset hash
            if (StringUtils.isEmpty(key) || value == null) {
                throw new LsException("存入失败");
            }
            // 判断类型 存放string
            if (value instanceof String) {
                String strValue = (String) value;
                if (time != null) {
                    stringRedisTemplate.opsForValue().set(key, strValue, time, TimeUnit.SECONDS);// 存入模板
                    return true;
                } else {
                    stringRedisTemplate.opsForValue().set(key, strValue);    // 存入模板
                    return true;
                }
            }
            // 存放list类型
            if (value instanceof List) {
                List<Object> listValue = (List<Object>) value;
                stringRedisTemplate.opsForList().leftPush(key, listValue.toString());
                return true;
            }
        } catch (Exception e) {
            throw new LsException("存入失败");
        }
        throw new LsException("存入失败");
    }

    /**
     * 取String
     *
     * @param key
     * @return
     */
    public String getStringKey(String key) {
        if (key != null) {
            return this.ForValue().get(key);
        }
        return null;
    }


    public StringRedisTemplate stringRedisTemplate() {
        return stringRedisTemplate;
    }


    /**
     * 设置 nx
     *
     * @param key
     * @return
     */
    public Boolean setNx(String key, String value) {
        if (key != null) {
            return stringRedisTemplate.opsForValue().setIfAbsent(key, value);
        }
        return false;
    }

    /**
     * 设置 nx
     *
     * @param key
     * @return
     */
    public void setEx(String key, Integer value) {
        if (key != null) {
            stringRedisTemplate.boundValueOps(key).increment(value);
        }
    }


    /**
     * 取keys
     *
     * @param key
     * @return
     */
    public Set getKeys(String key) {
        if (key != null) {
            return stringRedisTemplate.keys(key + "*");
        }
        return null;
    }

    public String getListKey(String key) {
        if (key != null) {
            String leftPop = stringRedisTemplate.opsForList().leftPop(key);
            return leftPop;
        }
        return null;
    }

    //获取key 过期时间
    public Long getTtl(String key) {
        return stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    //redis 删除当前库的所有数据
    public void delKeyAll(String key) {
        Set<String> keys = stringRedisTemplate.keys(key + "*");
        if (keys != null) {
            stringRedisTemplate.delete(keys);
        }
    }

    //redis 统计数据 在线人数数据
    public int userCount() {
        Set<String> keys = stringRedisTemplate.keys("*");
        if (keys != null && keys.size() > 0) {
            return keys.size();
        }
        return 0;
    }

    //redis 删除数据
    public Boolean delKey(String key) {
        try {
            if (key != null) {
                return stringRedisTemplate.delete(key);
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
