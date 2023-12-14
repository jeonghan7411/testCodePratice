package org.example.password;

import org.example.password.PasswordValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 테스트 코드는 프로덕션 의 패키지와 똑같이 해줘야함
 * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
 * 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.
 * 경계조건에 대해 테스트 코드를 작성해야 한다.
 */
public class PasswordValidatorTest {

    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordTest() {
        assertThatCode(() -> PasswordValidator.validate("serverwizard"))
                .doesNotThrowAnyException();
        //assertThat은 가독성을 위해 doesNotThrowAnyException 말그대로 위에있는 코드가 호출되었을때 어떠한 익셉션을 발생시키지않는다.
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외 발생")
    @ParameterizedTest //의존성 추가해야함
    @ValueSource(strings = {"aabbcce","aabbccddeeffg"}) //경계값을 위해 이렇게 테스트  ParameterizedTest 와 같이사용
    void validatePasswordTest2(String password) {
        assertThatCode(()->PasswordValidator.validate("aabb"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다");
                //예외 처리 발생시킨다
    }
}
