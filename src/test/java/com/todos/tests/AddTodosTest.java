package com.todos.tests;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import com.todos.pages.TodoPages;
import com.todos.utils.Setup;

public class AddTodosTest extends Setup {

	public AddTodosTest() throws IOException {
		super();

	}

	TodoPages todopage;

	@Test
	public void iAddToDo() throws IOException {

		todopage = new TodoPages();
		boolean fieldToDo = todopage.isElementDisplayed(TodoPages.inputField);
		Assertions.assertTrue(fieldToDo);
		todopage.fillTodo(prop.getProperty("todo1"));

		String getText = todopage.checkElementContain(TodoPages.textToDo);
		Assertions.assertTrue(getText.contains(prop.getProperty("todo1")));

		boolean checkbox = todopage.isChekboxSelected(TodoPages.checkboxToDo);
		Assertions.assertFalse(checkbox);
	}
}
