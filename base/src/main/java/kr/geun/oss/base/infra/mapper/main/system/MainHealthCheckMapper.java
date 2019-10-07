package kr.geun.oss.base.infra.mapper.main.system;

import kr.geun.oss.base.infra.config.mysql.annotation.MainDb;

/**
 * MainHealthCheck
 *
 * @author akageun
 * @since 2019-10-07
 */
@MainDb
public interface MainHealthCheckMapper {

    String selectNow();
}
