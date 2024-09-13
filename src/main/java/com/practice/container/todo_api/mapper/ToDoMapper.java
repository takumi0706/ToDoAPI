package com.practice.container.todo_api.mapper;

import com.practice.container.todo_api.entity.ToDo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ToDoMapper {
    @Select("SELECT * FROM todos")
    List<ToDo> findAll();

    @Select("SELECT * FROM todos WHERE id = #{id}")
    ToDo findById(int id);

    @Insert("INSERT INTO todos (task, completed) VALUES (#{task}, #{completed})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(ToDo todo);

    @Update("UPDATE todos SET task = #{task}, completed = #{completed} WHERE id = #{id}")
    void update(ToDo todo);

    @Delete("DELETE FROM todos WHERE id = #{id}")
    void delete(int id);
}
