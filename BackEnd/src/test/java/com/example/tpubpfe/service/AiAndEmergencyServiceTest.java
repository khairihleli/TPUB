package com.example.tpubpfe.service;

import com.example.tpubpfe.dto.ContentCheckRequest;
import com.example.tpubpfe.dto.ContentCheckResponse;
import com.example.tpubpfe.dto.EmergencyMessageRequest;
import com.example.tpubpfe.dto.EmergencyMessageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AiAndEmergencyServiceTest {

    @Autowired
    private ContentCheckService contentCheckService;

    @Autowired
    private EmergencyMessageService emergencyMessageService;

    @Test
    void shouldCreateAiCheckAndEmergencyMessage() {
        ContentCheckResponse check = contentCheckService.create(new ContentCheckRequest(1L, "IMAGE", 25, 80, "No issues", "APPROVED", "Safe for publishing"));
        EmergencyMessageResponse message = emergencyMessageService.create(new EmergencyMessageRequest("Alert", "Traffic disruption", "Tunis Center", null, null, 1));

        assertThat(check.getId()).isNotNull();
        assertThat(message.getId()).isNotNull();
        assertThat(check.getAiStatus()).isEqualTo("APPROVED");
    }
}
