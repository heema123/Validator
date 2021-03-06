package io.github.anderscheow.validator.rules.common;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import java.util.Locale;

import io.github.anderscheow.validator.rules.BaseRule;

public class ContainRule extends BaseRule {

    private String keyword;

    public ContainRule(@NonNull String keyword) {
        super(String.format(Locale.getDefault(), "Value does not contain '%s'", keyword));
        this.keyword = keyword;
    }

    public ContainRule(@NonNull String keyword, @StringRes int errorRes) {
        super(errorRes);
        this.keyword = keyword;
    }

    public ContainRule(@NonNull String keyword, @NonNull String errorMessage) {
        super(errorMessage);
        this.keyword = keyword;
    }

    @Override
    public boolean validate(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }

        if (value instanceof String) {
            return ((String) value).contains(keyword);
        }

        throw new ClassCastException("Required String value");
    }
}
