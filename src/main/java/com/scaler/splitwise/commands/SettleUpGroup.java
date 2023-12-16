package com.scaler.splitwise.commands;

import com.scaler.splitwise.controllers.SettleUpController;
import com.scaler.splitwise.dtos.SettleUpGroupRequestDto;
import com.scaler.splitwise.dtos.SettleUpGroupResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpGroup implements Command {

    /*
    Expected Input :- SettleUpGroup <group_id>


    settleUpGroup 1234
     */
    private SettleUpController settleUpController;

    public SettleUpGroup(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));

        Long groupId = Long.valueOf(words.get(1));

        SettleUpGroupRequestDto settleUpGroupRequestDto = new SettleUpGroupRequestDto();
        settleUpGroupRequestDto.setGroupId(groupId);

        SettleUpGroupResponseDto settleUpGroupResponseDto = settleUpController.settleUpGroup(settleUpGroupRequestDto);
    }

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));

        return words.size() == 2 && words.get(0).equals(CommandKeywords.SettleUpGroup);
    }
}
