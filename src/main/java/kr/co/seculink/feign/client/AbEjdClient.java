package kr.co.seculink.feign.client;

import kr.co.seculink.feign.vo.AlrmVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="abEjd", url="${api.url.abejd}")
public interface AbEjdClient
{
    // 헬스케어 처리
    @PostMapping(path="/alam/v1/alam.ab", consumes="application/json")
    public AlrmVO sendPush(@RequestBody AlrmVO vo);
}
