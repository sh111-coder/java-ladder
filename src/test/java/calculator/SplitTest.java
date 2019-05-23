package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitTest {
    @Test
    public void Split() {
        String[] values = "1".split(",");
        assertThat(new String[] {"1"}).isEqualTo(values);

        values = "1,2".split(",");
        assertThat(new String[] {"1","2"}).isEqualTo(values);
    }
}