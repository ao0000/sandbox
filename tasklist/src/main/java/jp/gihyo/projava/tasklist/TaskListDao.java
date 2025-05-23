package jp.gihyo.projava.tasklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TaskListDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    TaskListDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(TaskItem taskItem) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(taskItem);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("task_list");
        insert.execute(param);
    }

    public List<TaskItem> findAll() {
        String query = "SELECT * FROM task_list";

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);
        return result.stream()
                .map(
                    (Map<String, Object> row) ->
                            new TaskItem(
                                    row.get("id").toString(),
                                    row.get("task").toString(),
                                    row.get("deadline").toString(),
                                    (Boolean) row.get("done")
                            )
                ).toList();
    }

    public int delete(String id){
        return jdbcTemplate.update("DELETE FROM task_list WHERE id = ?", id);
    }

    public int update(TaskItem taskItem) {
        int number = jdbcTemplate.update(
                "update task_list set task = ?, deadline = ?, done = ? where id = ?",
                taskItem.task(),
                taskItem.deadline(),
                taskItem.done(),
                taskItem.id()
        );
        return number;
    }
}
