package cvr.otus.shell;

import cvr.otus.fake.FakeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import static java.lang.System.exit;

@ShellComponent
public class ShellOther {
    private final FakeData fakeData;

    @Autowired
    public ShellOther(FakeData fakeData) {
        this.fakeData = fakeData;
    }


    @ShellMethod(value = "Bye", group = "Общие")
    public void bye(@ShellOption String name) {
        exit(0);
    }


    @ShellMethod(value = "Заполнить фейком", group = "Общие")
    public void fake() {
        fakeData.init();
    }

}
