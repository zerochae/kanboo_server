package com.kanboo.www.domain.entity.global;

import com.kanboo.www.dto.global.CodeDetailDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CodeDetail {

    @Id
    private String codeDetailIdx;

    @ManyToOne
    @JoinColumn(name = "master_code_idx")
    private MasterCode masterCode;

    private String codeDetailKo;
    private String codeDetailEn;

    public CodeDetailDto entityToDto() {
        return CodeDetailDto.builder()
                .codeDetailIdx(codeDetailIdx)
                .masterCode(masterCode.entityToDto())
                .codeDetailKo(codeDetailKo)
                .codeDetailEn(codeDetailEn)
                .build();
    }
}
