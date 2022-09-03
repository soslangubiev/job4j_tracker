package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {
    @Test
    public void whenSingleValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(List.of("1"));
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(Arrays.asList("1", "5"));
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        int nextSelected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
        assertThat(nextSelected).isEqualTo(5);
    }

    @Test
    public void whenSingleInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(Arrays.asList("one", "1"));
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenMultipleInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(Arrays.asList("one", "five", "1"));
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(Arrays.asList("-1", "1"));
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}