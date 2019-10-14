package kr.geun.oss.admin.config.security.model;

import kr.geun.oss.base.common.constants.AcConst;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
public class AdminUserTest {

    @Test
    public void localDateTimeTest() {
        LocalDateTime ldt = LocalDateTime.of(2019, 10, 10, 0, 0).minus(Duration.ofDays(AcConst.LOGIN_EXPIRED_PERIOD));

        LocalDateTime ldt2 = LocalDateTime.of(2019, 8, 12, 0, 0);
        Assert.assertTrue(ldt.isBefore(ldt2));

        LocalDateTime ldt3 = LocalDateTime.of(2019, 8, 10, 0, 0);
        Assert.assertFalse(ldt.isBefore(ldt3));
    }

}
