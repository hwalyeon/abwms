package kr.co.seculink.feign.service;

import kr.co.seculink.exception.BizException;
import kr.co.seculink.feign.vo.AlrmVO;

public interface FeignService
{
    AlrmVO sendPush(AlrmVO params) throws BizException;
}
