package team.themoment.hellogsm.web.global.thirdParty.aws.service;

import org.springframework.stereotype.Component;

import io.awspring.cloud.sns.sms.SmsMessageAttributes;
import io.awspring.cloud.sns.sms.SmsType;
import io.awspring.cloud.sns.sms.SnsSmsTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import team.themoment.hellogsm.web.domain.identity.service.CodeNotificationService;

@Component
@RequiredArgsConstructor
@Slf4j
public class CodeNotificationServiceImpl implements CodeNotificationService {
    private final static String MAX_PRICE = "1.00";
    private final SnsSmsTemplate smsTemplate;

    @Override
    public void execute(String phoneNumber, String code) {
        log.warn("send to : " + createPhoneNumber(phoneNumber));
        smsTemplate
                .send(createPhoneNumber(phoneNumber), createMessage(code), SmsMessageAttributes.builder()
                        .smsType(SmsType.TRANSACTIONAL).maxPrice(MAX_PRICE).build());
    }

    private static String createMessage(String code) {
        return "[Hello, GSM] 본인인증번호 [" + code + "]를 입력해주세요.";
    }

    private static String createPhoneNumber(String phoneNumber) {
        return "+82" + phoneNumber.replaceFirst("0","");
    }
}
