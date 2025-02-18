package com.ensao.gi5.lint.runner;

import com.ensao.gi5.lint.Linter;
import com.ensao.gi5.lint.printer.ConsolePrinter;
import com.ensao.gi5.lint.rules.AttributeStartByLowerCaseRule;
import com.ensao.gi5.lint.rules.CatchRule;
import com.ensao.gi5.lint.rules.ConstantsInUpperCaseRule;
import com.ensao.gi5.lint.rules.EnumElementIsUpperRule;
import com.ensao.gi5.lint.rules.IfElseRule;
import com.ensao.gi5.lint.rules.LinesBodyMethodRule;
import com.ensao.gi5.lint.rules.NumberOfMethodsRule;
import com.ensao.gi5.lint.rules.ParametersMethodRule;
import com.ensao.gi5.lint.rules.RuleTwoRule;
import com.ensao.gi5.lint.rules.StatementAnonymRule;
import com.ensao.gi5.lint.rules.StatementBooleanRule;
import com.ensao.gi5.lint.rules.ThrowReturnMethodRule;
import com.ensao.gi5.lint.rules.UnusedImportsRule;
import com.ensao.gi5.lint.rules.VariableStartByLowerCaseRule;
import com.ensao.gi5.lint.rules.VisibilityAttributeRule;

public class Runner {
    public static void main(String[] args) {

        if (args == null || args.length == 0) {
            System.out.println("Usage example -s  D:/Test/Example.java");
            throw new IllegalStateException("arguments are empty");
        }

        String directory = null;

        for (int i = 0; i < args.length; i++) {
            String argument = args[i];
            if (argument.equals("-s")) {
                if (i == args.length - 1 || (directory = args[i + 1]).isEmpty()) {
                    System.out.println("Usage example : -s  D:/Test/Example.java");
                    throw new IllegalStateException("The directory or file are not specified");
                }
            }
        }
        final Linter linter = new Linter();
        linter.registerRule(new UnusedImportsRule());
        linter.registerRule(new ConstantsInUpperCaseRule());
        linter.registerRule(new AttributeStartByLowerCaseRule());
        linter.registerRule(new VariableStartByLowerCaseRule());   
        linter.registerRule(new EnumElementIsUpperRule());
        linter.registerRule(new LinesBodyMethodRule());
        linter.registerRule(new ParametersMethodRule());
        linter.registerPrinter(new ConsolePrinter());
        linter.registerRule(new ThrowReturnMethodRule());
        linter.registerRule(new RuleTwoRule());
        linter.registerRule(new StatementBooleanRule());
        linter.registerRule(new StatementAnonymRule());
        linter.registerRule(new NumberOfMethodsRule());
        linter.registerRule(new VisibilityAttributeRule());
       linter.registerRule(new CatchRule());
        linter.registerRule(new IfElseRule());
        linter.registerPrinter(new ConsolePrinter());
        linter.registerSource(directory);
        linter.run();
    }
}
