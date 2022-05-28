/**
 *  SimpleSpStringBuilder是基于SpannableStringBuilder的简单封装，全称为SimpleSpannableStringBuildUtil。
 *  SimpleSpStringBuilder的存在主要是为了解决SpannableStringBuilder所存在的两方面问题：
 *   1.由于其在使用样式时需要指定字符区间，如果我们的字符串不是固定长度，或需要动态添加时，这会很繁琐，因为我们必须构建多个Span，
 *   且实时计算下区间范围。这会产生很大的代码量，减少代码可读性，且计算下标时容易出错。
 *   2.其在添加图片时会比较复杂，这特别体现在设置图片大小和间距时。
 *  SimpleSpStringBuilder的存在解决了以上问题，并且有以下优点：
 *   1.使用建造者模式，我们可以新建一个新的对象[.create()]或者使用原来的对象[.used()]，进行字符和图片的添加，代码更简洁，可读性很强。
 *   2.内部动态维护区间值start，end，防止了开发者由于区间计算错误导致的错误。
 *   3.增加setImage()和setView()方法，使其具有更强大功能。
 *  示例如下：
 *  ~~~
 *  示例1：
 *  val stringBuilder = SimpleSpStringBuilder(context)
 *         .create()
 *         .setText(text = "hello", textColorStr = "#A4A9B3")
 *         .setText(text = "：word", textColorStr = "#181E25")
 *         .builder()
 *
 *  输出：hello：word
 *  ~~~
 *
 * ~~~
 * 示例2：
 * val stringBuilder2 = SimpleSpStringBuilder(context)
 *     .used(SpannableStringBuilder())
 *     .setText(text = "hello", textColorStr = "#A4A9B3")
 *     .setText(text = "word", textColorStr = "#181E25")
 *     .setView(view = View(context), width = 20, height = 30)
 *     .builder()
 *  ~~~
 *  输出：hello：word （image）
 *
 *  @author mingxiaoxu
 *  @data 2022-5-28
 */