package solution;

import util.DoubleNode;
/**
 * A DoubleLinkedSeq is a sequence of double numbers. The sequence can have a
 * special &quot;current element&quot;, which is specified and accessed through
 * four methods that are not available in the IntArrayBag class (start,
 * getCurrent, advance, and isCurrent).
 * 
 * Limitations:
 * 
 * Beyond Integer.MAX_VALUE element, the size method does not work.
 * 
 * @author Ian Apelgren
 * @version 1
 */
public class DoubleLinkedSeq implements Cloneable
{

    // your non-static fields go here.
    private DoubleNode head; 
    private DoubleNode tail;
    private DoubleNode cursor;
    private DoubleNode precursor;
    private int manyNodes;

    /**
     * Initializes an empty DoubleLinkedSeq.
     * 
     * @postcondition This sequence is empty.
     */
    public DoubleLinkedSeq()
    {
        //tail is the last node so a working tail will not be null!
        head = null;
        tail = null;
        cursor = head;
        precursor = head;
        manyNodes = 0;
    }

    /**
     * Adds a new element to this sequence.
     * 
     * @param element
     *            the new element that is being added to this sequence.
     * 
     * @postcondition a new copy of the element has been added to this sequence.
     *                If there was a current element, then this method places
     *                the new element before the current element. If there was
     *                no current element, then this method places the new
     *                element at the front of this sequence. The newly added
     *                element becomes the new current element of this sequence.
     */
    public void addBefore(double element)
    {
        // code for addBefore
        //case 1 if there is a current element
        if (isCurrent() == true)
        {
            //if the current element is the head
            if (cursor == head)
            {
                precursor = new DoubleNode(element, cursor);
                head = precursor;
                cursor = precursor;
                manyNodes++;
            }
            //if the current element is not the head
            else
            {
                precursor.addNodeAfter(element);
                cursor = precursor.getLink();
                manyNodes++;
            }
            
        }
        //case 2 if there is no current element
        else
        {
            //if there is a head
            if (head != null)
            {
                precursor.addNodeAfter(element);
                cursor = precursor.getLink();
                manyNodes++;
            }
            //empty
            else
            {
                head = new DoubleNode(element, null);
                tail = head;
                cursor = head;
                precursor = cursor;
                manyNodes++;
            }
        }
    }

    /**
     * Adds a new element to this sequence.
     * 
     * @param element
     *            the new element that is being added to this sequence.
     * 
     * @postcondition a new copy of the element has been added to this sequence.
     *                If there was a current element, then this method places
     *                the new element after the current element. If there was no
     *                current element, then this method places the new element
     *                at the end of this sequence. The newly added element
     *                becomes the new current element of this sequence.
     */
    public void addAfter(double element)
    {

        // your code here
        //case 1: Is current element
        if (isCurrent() == true)
        {
            cursor.addNodeAfter(element);
            precursor = cursor; 
            cursor = cursor.getLink();
            manyNodes++;
        }
        //case 2: no current element
        else
        {
            //case 2.1 Is a tain but no current
            if (tail != null)
            {
                tail.addNodeAfter(element);
                precursor = tail;
                tail = tail.getLink();
                cursor = tail;
                manyNodes++;
            }
            //case 2.2 no tail means an empty array
            else
            {
                tail = new DoubleNode(element, null);
                precursor = tail;
                cursor = tail;
                head = tail;
                manyNodes++;
            }
        }
    }

    /**
     * Places the contents of another sequence at the end of this sequence.
     * 
     * @precondition other must not be null.
     * 
     * @param other
     *            a sequence show contents will be placed at the end of this
     *            sequence.
     * 
     * @postcondition the elements from other have been placed at the end of
     *                this sequence. The current element of this sequence
     *                remains where it was, and other is unchanged.
     * 
     * @throws NullPointerException
     *             if other is null.
     */
    public void addAll(DoubleLinkedSeq other) throws NullPointerException
    {
        // your code here
        DoubleNode[] copy;
        if (other == null)
        {
            throw new NullPointerException("you can't add an empty node chain");
        }
        else
        {
            copy = DoubleNode.listCopyWithTail(other.head);
            tail.getLink().setLink(copy[0]);
            copy[1].setLink(null);
            tail.setLink(copy[0]);
            manyNodes += other.size();
        }   
    }

    /**
     * Move forward so that the current element is now the next element in the
     * sequence.
     * 
     * @precondition isCurrent() returns true.
     * 
     * @postcondition If the current element was already the end element of this
     *                sequence (with nothing after it), then there is no longer
     *                any current element. Otherwise, the new element is the
     *                element immediately after the original current element.
     * 
     * @throws IllegalStateException
     *             if there is not current element.
     */
    public void advance() throws IllegalStateException
    {
        if (isCurrent() == true) 
        {
            precursor = cursor;
            cursor = cursor.getLink();
        }
        else
        {
            throw new IllegalStateException("There is no current element");
        }
        
    }

    /**
     * Creates a copy of this sequence.
     * 
     * @return a copy of this sequence. Subsequent changes to the copy will not
     *         affect the original, nor vice versa.
     * @throws RuntimeException
     *             if this class does not implement Cloneable.
     * 
     */
    public DoubleLinkedSeq clone() throws RuntimeException
    {
        DoubleLinkedSeq answer;
        try 
        {
            answer = (DoubleLinkedSeq) super.clone();
        } 
        catch (CloneNotSupportedException e) 
        {
            throw new RuntimeException(
                "clone: This class does not implement Cloneable");
        }
        
        DoubleNode[] newList = DoubleNode.listCopyWithTail(head);

        answer.head = newList[0];
        answer.tail = newList[1];
        

        return answer;
        
    }

    /**
     * Creates a new sequence that contains all the elements from s1 followed by
     * all of the elements from s2.
     * 
     * @precondition neither s1 nor s2 are null.
     * 
     * @param s1
     *            the first of two sequences.
     * @param s2
     *            the second of two sequences.
     * 
     * @return a new sequence that has the elements of s1 followed by the
     *         elements of s2 (with no current element).
     * 
     * @throws NullPointerException
     *             if s1 or s2 are null.
     */
    public static DoubleLinkedSeq concatenation(DoubleLinkedSeq s1,
            DoubleLinkedSeq s2) throws NullPointerException
    {
        // your code here.
        // change this return!
        if (s1 == null || s2 == null)
        {
            throw new NullPointerException(
                "please make sure your arrays aren't null");
        }
        DoubleLinkedSeq twoNodes = new DoubleLinkedSeq();
        twoNodes.addAll(s1);
        twoNodes.addAll(s2);
        twoNodes.manyNodes = (s1.manyNodes + s2.manyNodes);
        
        return twoNodes;
    }

    /**
     * Returns a copy of the current element in this sequence.
     * 
     * @precondition isCurrent() returns true.
     * 
     * @return the current element of this sequence.
     * 
     * @throws IllegalStateException
     *             if there is no current element.
     */
    public double getCurrent() throws IllegalStateException
    {
        // your code goes here
        // change this return!
        if (isCurrent() == true)
        {
            return cursor.getData();
        }
        else
        {
            throw new IllegalStateException("There is no current element");
        }
        
    }

    /**
     * Determines whether this sequence has specified a current element.
     * 
     * @return true if there is a current element, or false otherwise.
     */
    public boolean isCurrent()
    {
        if (cursor != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Removes the current element from this sequence.
     * 
     * @precondition isCurrent() returns true.
     * 
     * @postcondition The current element has been removed from this sequence,
     *                and the following element (if there is one) is now the new
     *                current element. If there was no following element, then
     *                there is now no current element.
     * 
     * @throws IllegalStateException
     *             if there is no current element.
     */
    public void removeCurrent() throws IllegalStateException
    {
        if (isCurrent() == true)
        {
            //case 1 1 element
            if (head == tail)
            {
                head = null;
                tail = null;
                cursor = null;
                precursor = null;
                manyNodes--;
                
               
            }
            //case 2 first element
            else if (cursor == head)
            {
                head = head.getLink();
                cursor = head;
                precursor = head;
                manyNodes--;
                
               
            }
            //case 3 last element
            else if (cursor == tail)
            {
                cursor = precursor;
                tail = cursor;
                cursor.setLink(null);
                precursor = head;
                while 
                    (precursor.getLink() != cursor 
                        && precursor.getLink() != null)
                {
                    precursor = precursor.getLink();
                }
                manyNodes--;
                
              
            }
            else
            {
                cursor = cursor.getLink();
                precursor.setLink(cursor);
                manyNodes--;
                
               
            }
        }
        else
        {
            throw new IllegalStateException("There is no current element");
        }
    }

    /**
     * Determines the number of elements in this sequence.
     * 
     * @return the number of elements in this sequence.
     */
    public int size()
    {
        
        return manyNodes;
    }

    /**
     * Sets the current element at the front of this sequence.
     * 
     * @postcondition If this sequence is not empty, the front element of this
     *                sequence is now the current element; otherwise, there is
     *                no current element.
     */
    public void start()
    {
        //is head
        if (head != null)
        {
            cursor = head;
            precursor = head;
        }
        //no head
        else
        {
            cursor = null;
            precursor = null;
        }
    }

    /**
     * Returns a String representation of this sequence. If the sequence is
     * empty, the method should return &quot;&lt;&gt;&quot;. If the sequence has
     * one item, say 1.1, and that item is not the current item, the method
     * should return &quot;&lt;1.1&gt;&quot;. If the sequence has more than one
     * item, they should be separated by commas, for example: &quot;&lt;1.1,
     * 2.2, 3.3&gt;&quot;. If there exists a current item, then that item should
     * be surrounded by square braces. For example, if the second item is the
     * current item, the method should return: &quot;&lt;1.1, [2.2],
     * 3.3&gt;&quot;.
     * 
     * @return a String representation of this sequence.
     */
    @Override
    public String toString()
    {
        DoubleNode tempCursor = null;
        // your code here.
        // change this return!
        StringBuilder str = new StringBuilder();
        str.append("<");
        //case1: set is empty or there are no items in it returns <>.
        if (head == null || manyNodes == 0)
        {
            str.append(">");
        }
        else
        {
            tempCursor = head;
            while (tempCursor != null)
            {
                //puts casts arround cuttentIndex if applicable
                if (tempCursor == cursor)
                {
                    str.append("[" + tempCursor.getData() + "]");
                }
                //normal appending
                else
                {
                    str.append(tempCursor.getData());
                }
                //comma and space if not
                if (tempCursor.getLink() != null)
                {
                    str.append(", ");
                }
                tempCursor = tempCursor.getLink();
            }
            str.append(">");
        }
        return str.toString();
    }

    /**
     * Determines if this object is equal to the other object.
     * 
     * @param other
     *            The other object (possibly a DoubleLinkedSequence).
     * @return true if this object is equal to the other object, false
     *         otherwise. Two sequences are equal if they have the same number
     *         of elements, and each corresponding element is equal
     */
    public boolean equals(Object other)
    {
        
        return false;
    }
}
