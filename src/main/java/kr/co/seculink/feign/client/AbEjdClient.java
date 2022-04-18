package kr.co.seculink.feign.client;

import feign.RequestLine;
import kr.co.seculink.feign.vo.AlrmVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="abEjd")
public interface AbEjdClient
{
    // 알람전송
    @PostMapping(path="/alam/v1/alam.ab", consumes="application/json")
    public AlrmVO sendPush(@RequestBody AlrmVO vo);
}
