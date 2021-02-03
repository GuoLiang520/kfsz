package com.gl.lucene;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;

/**
 *
 * @author 郭亮
 * @date 2021/1/26 14:35
 **/
public class IKTokenizer extends Tokenizer {

    private IKSegmenter _IKSegmenter;

    private final CharTermAttribute charTermAttribute;

    private final OffsetAttribute offsetAttribute;

    private final TypeAttribute typeAttribute;

    private int endPosition;

    public IKTokenizer() {
        this(true);
    }

    public IKTokenizer(boolean userSmart) {
        super();
        charTermAttribute = addAttribute(CharTermAttribute.class);
        offsetAttribute = addAttribute(OffsetAttribute.class);
        typeAttribute = addAttribute(TypeAttribute.class);
        _IKSegmenter = new IKSegmenter(input, userSmart);
    }
    @Override
    public boolean incrementToken() throws IOException {
        clearAttributes();
        Lexeme next = _IKSegmenter.next();
        if (next != null) {
            charTermAttribute.append(next.getLexemeText());
            charTermAttribute.setLength(next.getLength());

            offsetAttribute.setOffset(next.getBeginPosition(), next.getEndPosition());
            this.endPosition = next.getEndPosition();

            typeAttribute.setType(next.getLexemeTypeString());
            return true;
        }
        return false;
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        _IKSegmenter.reset(input);
    }

    @Override
    public final void end() {
        // set final offset
        int finalOffset = correctOffset(this.endPosition);
        offsetAttribute.setOffset(finalOffset, finalOffset);
    }
}
