package com.cxt.esl.util.enumType;

public enum WorkStatus {
	/*��-1 δ֪�쳣��0 ��ʼ��1 ������2 ����ͼƬ��3 �·�ͼƬûfeedback��4 �·�ͼƬ��feedback��5 esl ������'*/
	// ���ù��캯������
    EXCEPTION(-1), INITIAL(0), NORMAL (1),GENERRATE_PIC(2),NO_FEEDBACK(3),FEEDBACK(4),NO_ONLINE(5);

    // ����˽�б���
    private int nCode ;

    // ���캯����ö������ֻ��Ϊ˽��
    private WorkStatus( int _nCode) {
        this . nCode = _nCode;
    }

    @Override
    public String toString() {
        return String.valueOf ( this . nCode );
    }
}

