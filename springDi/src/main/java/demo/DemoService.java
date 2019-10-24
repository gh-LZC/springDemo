package demo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @class DemoService
 * @Author Administrator
 * @Description //TODO
 * @Date 19-10-24 下午3:35
 * @Version 1.0
 */
@Service
@Data
public class DemoService {
    @Value("其他类型的属性")
    private String another;
}
