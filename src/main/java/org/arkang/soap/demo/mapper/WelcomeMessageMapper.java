package org.arkang.soap.demo.mapper;

import org.apache.ibatis.annotations.*;
import org.arkang.soap.demo.model.MessageResponse;

@Mapper
public interface WelcomeMessageMapper {

    @Select("SELECT message, message_count FROM WS_MESSAGE WHERE message_id = #{id}")
    MessageResponse getWelcomeMessage(@Param("id") String id);

    @Update("UPDATE WS_MESSAGE SET message_count = #{count} WHERE message_id = #{id}")
    void updateMessageCount(@Param("count") int count, @Param("id") String id);

    @Flush
    void flush();
}
