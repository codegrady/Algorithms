package other;

/**
 * S = "aa??bbb"
 * 用a或b替换？
 * 最长相同字符子串尽可能短
 *  aaaabbb => 4
 *  aababbb => 3
 *
 *  ? 两端 字符相同
 *  奇数个？ 外-》内 依次相反字符
 *  偶数个？ 外-》内 依次相反字符
 *  ？ 两端 字符不同
 *  奇数个　且大于１个　？ 外-》内 依次相反字符
 *  偶数个？外-》内 依次相反字符
 *  １个？　比较？两端相同字符的个数，替换长度小的那个
 */
public class ShortestLongSame {
}
