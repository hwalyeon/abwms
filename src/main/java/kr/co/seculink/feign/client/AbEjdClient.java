package kr.co.seculink.feign.client;

import kr.co.seculink.feign.vo.AlrmVO;
import kr.co.seculink.feign.vo.HlthCareVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="abEjd")
public interface AbEjdClient
{
    // 알람전송
    @PostMapping(path="/alam/v1/alam.ab", consumes="application/json")
    public AlrmVO sendPush(@RequestBody AlrmVO vo);

    // 헬스케어 처리
    @PostMapping(path="/hc/v1/healthcare.ab", consumes="application/json")
    public HlthCareVO healthcare(@RequestBody HlthCareVO vo);
}
