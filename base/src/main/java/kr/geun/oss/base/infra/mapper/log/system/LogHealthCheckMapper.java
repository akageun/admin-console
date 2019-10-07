package kr.geun.oss.base.infra.mapper.log.system;

import kr.geun.oss.base.infra.config.mysql.annotation.LogDb;

/**
 * LogHealthCheckMapper
 *
 * @author akageun
 * @since 2019-10-07
 */
@LogDb
public interface LogHealthCheckMapper {

    String selectNow();
}
