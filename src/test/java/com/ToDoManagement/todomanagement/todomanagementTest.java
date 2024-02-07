package com.ToDoManagement.todomanagement;

import com.ToDoManagement.todomanagement.entity.Todo;
import com.ToDoManagement.todomanagement.repository.ToDoRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class todomanagementTest {

    @Autowired
    ToDoRepository toDoRepository;

    Todo todo = new Todo(0L, "hello3", "3world", true);


    @Test
    void testInsertionToDB() {
        try {
            List<Todo> todo1=toDoRepository.findAll();

            System.out.println(todo1);

            if(!todo1.isEmpty())
            {
                //Todo todo = new Todo(0L, "hello3", "3world", true);

                var s = this.toDoRepository.save(todo);
                Assertions.assertEquals("hello3", todo.getTitle());
            }
            else {
                throw new AssertionError("Add some element first");


            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test
    void testDeletionToDB() {
        try {
            List<Todo> todos = toDoRepository.findAll();

            if (todos.isEmpty()) {
                throw new AssertionError("Add some elements first to delete");
            } else {
                try {
                    Optional<Todo> todoOptional = toDoRepository.findByDescription(todo.getDescription());

                    if (!todoOptional.isPresent()) {
                        throw new AssertionError("Todo not found with the provided description");
                    }

                    Todo todo = todoOptional.get();
                    toDoRepository.delete(todo);

                    // Assertions after deletion
                    Assertions.assertNull(toDoRepository.findByDescription(todo.getDescription()).orElse(null), "Todo should not exist after deletion");
                } catch (Error e) {
                    // Handle the case where the query returns multiple results
                   // e.printStackTrace();
                    Assertions.fail("Multiple todos found with the same description, unable to proceed with deletion");
                } catch (Exception e) {
                    e.printStackTrace();
                    Assertions.fail("An unexpected error occurred during deletion");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("An unexpected error occurred before deletion");
        }
    }

}