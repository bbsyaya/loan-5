package com.loan.api.annotation.resolver;

import com.loan.api.annotation.IpLimitAnnotation;
import com.loan.common.utils.IPUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by shuttle on 5/31/17.
 */
public class IpLimitResolver extends BaseAnnotationsResolver {

//    @Autowired
//    RedisClusterRepository      redisClusterRepository;

    private final static String IP_LIMIT_PRE_COUNT = "ip_limit_count_111.204.157.138";
    private final static String IP_LIMIT_PRE_TIME  = "ip_limit_time_";

    public boolean ipLimit(HttpServletRequest request, HttpServletResponse response) {
        Method method = super.baseResolver(request, response);
        IpLimitAnnotation limit = method.getAnnotation(IpLimitAnnotation.class);
        String ip = request.getParameter("ip");
        if (StringUtils.isBlank(ip) || ip.startsWith("172.16") || ip.startsWith("192.168")) {
            ip = IPUtil.getIpAddress(request);
        }
        /**
         * 临时开放限制
         */
        if(!StringUtils.isBlank(ip) && ip.equals("172.16.94.14")){
            return true;
        }

        if (limit != null && StringUtils.isNotBlank(ip)) {
            return caculateRegisterTimes(ip, limit.visitTimes(), limit.times());
        }
        return true;
    }

    /**
     * 但ip多少分钟访问多少次限制
     * @return
     */
    private boolean caculateRegisterTimes(String ip, int visitTimes, int times) {
        String countkey = IP_LIMIT_PRE_COUNT + ip;
        String timeKey = IP_LIMIT_PRE_TIME + ip;
        long count = 0;
//        if (!redisClusterRepository.existsKey(timeKey)) {
//            redisClusterRepository.del(countkey);
//            redisClusterRepository.set(timeKey, "true");
//            redisClusterRepository.expireOriginal(timeKey, times * 60);
//        }
//        count = redisClusterRepository.increBy(countkey, 1);
        if (count > visitTimes) {
            return false;
        }
        return true;
    }
}
